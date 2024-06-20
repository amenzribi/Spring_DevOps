pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'amen', url: 'https://github.com/amenzribi/Spring_DevOps.git'
            }
        }

        stage('Build and Test') {
            steps {
                dir('eventsProject') {
                    sh 'mvn -f pom.xml clean test'
                }
            }
        }

        stage('Cleanup') {
            steps {
                deleteDir() // Nettoyer l'espace de travail Jenkins
            }
        }
    }
}
