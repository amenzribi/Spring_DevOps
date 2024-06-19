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
                dir('DevOps_Project') {
                    script {
                        sh 'mvn clean test'
                    }
                }
            }
                        
        }
