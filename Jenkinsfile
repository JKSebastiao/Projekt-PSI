pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package dockerfile:build'
            }
        }
	stage('Deploy') {
            steps {
		sh 'docker stack deploy --orchestrator kubernetes --compose-file docker-compose.yml Dyplomowanie'
		sh 'kubectl get service'
            }
        }
    }
}