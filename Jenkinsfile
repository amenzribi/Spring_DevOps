pipeline {
    agent any

    stages {
        stage('Github Connection') {
            steps {
                echo "Getting Project from Git"
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], 
                          userRemoteConfigs: [[url: 'https://github.com/amenzribi/CI-CD.git']]])
            }
        }

        stage('Test Backend') {
            steps {
                dir('eventsProject') { 
                    script {
                        sh 'mvn clean test'
                    }
                }
            }
             post {
        always {
            junit 'eventsProject/target/surefire-reports/*.xml' // Chemin correct pour les rapports de test
        }
    }

        }
        
    }

  
}
