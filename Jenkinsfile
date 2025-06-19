pipeline {
    agent any

    tools {
        maven 'maven'
        jdk 'jdk17'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/irvingp/api-check-serenitybdd.git'
            }
        }
        stage('Clean and Verify') {
            steps {
                sh 'mvn clean verify'
            }
        }
    }

    post {
        always {
            junit '**/target/site/serenity/SERENITY-JUNIT-*.xml'
            archiveArtifacts artifacts: '**/target/site/serenity/**', fingerprint: true
            sh 'zip -r serenity-report.zip target/site/serenity || true'
        }

        failure {
            mail to: 'irvingpayan58@gmail.com',
                subject: "Resultado de pruebas: ${currentBuild.currentResult}",
                body: """
                    Hola equipo,

                    Las pruebas han fallado.

                    Pueden ver el reporte en Jenkins: ${env.BUILD_URL}

                    El resumen de Serenity está adjunto.
                """
        }
    }
}
