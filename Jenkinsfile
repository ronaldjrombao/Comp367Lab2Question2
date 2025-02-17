pipeline {
    agent any

    tools {
        maven "M3"
    }

    environment {
        GIT_REPO = 'git@github.com:ronaldjrombao/Comp367Lab2Question2.git'  // Use SSH URL
        BRANCH = 'master'
    }

    stages {
        stage('Clone Repository') {
            steps {
                echo 'Cloning repository using SSH...'
                git branch: "${BRANCH}", url: "${GIT_REPO}", credentialsId: 'Comp367-SSH'
            }
        }

        stage('Run Tests') {
            steps {
                echo 'Running tests...'
                sh 'mvn test'
            }
        }

        stage('Build Package') {
            steps {
                echo 'Building the project...'
                sh 'mvn clean package'
            }
        }
    }

    post {
        success {
            echo 'Build successful!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}