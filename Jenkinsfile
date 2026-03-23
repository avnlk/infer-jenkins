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
    }

    post {
        always {
            archiveArtifacts artifacts: 'infer-out/report.json', fingerprint: true
        }
    }
}
