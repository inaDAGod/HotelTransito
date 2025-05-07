pipeline {
    agent any

    triggers {
        githubPush() // Se ejecuta cuando GitHub envía un webhook de push
    }

    environment {
        DEPLOY_DIR = 'C:/xampp/tomcat/webapps/HotelTransito'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/inaDAGod/HotelTransito'
            }
        }

        stage('Build') {
            steps {
                echo 'No se requiere build para HTML estático'
                bat 'if not exist src\\index.html exit /b 1'
            }
        }

        stage('Deploy') {
            steps {
                echo "Desplegando en Tomcat..."
                bat "xcopy /E /I /Y src ${DEPLOY_DIR}"
            }
        }
    }

    post {
        success {
            echo "¡Despliegue exitoso!"
        }
        failure {
            echo "Hubo un error durante el pipeline."
        }
    }
}
