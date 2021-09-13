pipeline {
    agent any
    stages {
            steps {
                bat'mvn clean package -DskipTests'
            }
        }
        stage('Build Image') {
            steps {
                	bat "docker build -t='bharathgr/rightimage' ."
            }
        }
        stage('Push Image') {
            steps {
                withCredentials([usernamePassword(credentials: 'dockerhub',passwordVariable: 'pass', usernameVariable: 'user')] 
                    bat "docker login --username=${user} --password=${pass}"
                    bat "docker push bharathgr/rightimage:latest"    
                
                }
            }
        }
    }
}