pipeline {
    agent any

    stages {
        stage('Infer Analysis - C') {
            steps {
                sh '''
                    docker run --rm \
                        -v $(pwd):/work \
                        -w /work \
                        infer infer run --biabduction -- gcc src/leak.c src/null.c src/complexleak.c
                    cp infer-out/report.json infer-out-c-report.json

                    docker run --rm \
                        -v $(pwd):/work \
                        -w /work \
                        infer infer run -- gcc src/uaf.c
                    cp infer-out/report.json infer-out-uaf-report.json
                '''
            }
        }
        stage('Infer Analysis - Java') {
            steps {
                sh '''
                    docker run --rm \
                        -v $(pwd):/work \
                        -w /work \
                        infer infer run -- javac src/NullBug.java src/IntraNull.java src/InterNull.java src/OrderProcessor.java
                    cp infer-out/report.json infer-out-java-report.json
                '''
            }
        }
        stage('Convert Report') {
            steps {
                sh 'python3 convert_infer.py'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'infer-out-c-report.json, infer-out-uaf-report.json, infer-out-java-report.json', fingerprint: true
            recordIssues(
                tools: [gcc(pattern: 'infer-report.txt', name: 'Infer')]
            )
        }
    }
}
