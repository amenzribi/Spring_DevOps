pipeline {
    agent any

    stages {
        stage('Github Connection') {
            steps {
                echo "Getting Project from Git"
                checkout scm
            }
        }

        stage('Test Backend') {
            steps {
                dir('eventsProject') { // Changer le répertoire en 'eventsProject'
                    script {
                        sh 'mvn clean test'
                    }
                }
            }
        }
    }

    post {
        always {
            junit 'eventsProject/target/surefire-reports/*.xml' // Chemin correct pour les rapports de test
        }
    }
}
