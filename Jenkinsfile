pipeline {
    agent any

    stages {
        stage('Git Source Code') {
            steps {
                git 'https://github.com/karunakunde/HybridFramework.git'
            }
        }

        stage('Build Code') {
            steps {
                bat script: 'mvn compile'
            }
        }

        stage('Run Test') {
            steps {
                bat script: 'mv clean test -Dbrowser=localchrome -X'
            }
        }
    }
}
