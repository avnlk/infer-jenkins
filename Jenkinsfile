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
                sh '''
                    python3 -c "
import json
with open('infer-out/report.json') as f:
    issues = json.load(f)
with open('infer-out/report.txt', 'w') as out:
    for i in issues:
        out.write(f\"{i['file']}:{i['line']}: warning: [{i['bug_type']}] {i['qualifier']}\\n\")
"
                '''
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
