pipeline {
    agent any
    stages {
        stage('Infer Analysis') {
            steps {
                sh '''
                    docker run --rm \
                        -v $(pwd):/work \
                        -w /work \
                        infer infer run --biabduction -- gcc src/leak.c src/null.c
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
            archiveArtifacts artifacts: 'infer-out/report.json', fingerprint: true
            recordIssues(
                tools: [gcc(pattern: 'infer-out/report.txt', name: 'Infer')]
            )
        }
    }
}
