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
                sh 'docker-compose up'
            }
        }
    }
}