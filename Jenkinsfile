pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Spécifiez la branche à vérifier
                git branch: 'amen', url: 'https://github.com/amenzribi/CI-CD.git'
            }
        }

        stage('Build and Test') {
            steps {
                // Naviguer vers le répertoire contenant pom.xml
                dir('eventsProject') {
                    sh 'mvn clean test'
                }
            }
        }

        // Autres étapes à ajouter si nécessaire

        stage('Cleanup') {
            steps {
                deleteDir() // Nettoyer l'espace de travail Jenkins
            }
        }
    }
}