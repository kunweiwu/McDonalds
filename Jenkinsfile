#! groovy

pipeline {
    agent any

    environment {
        PATH = "$RUBY_HOME:$PATH"
    }

    stages {
        stage('Verify Ruby') {
            steps {
                sh 'ruby -v'
                sh 'bundler -v'
            }
        }
        stage('Setup') {
            steps {
                echo "Setup"
                // Install bundle in order to use fastlane
                // sh "gem install bundler"
                sh "bundle install"
            }
        }
        stage('Test') {
            steps {
                sh 'bundle exec fastlane test'
            }
        }
    }
}
