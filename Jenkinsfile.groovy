pipeline {
 agent any 
 tools {
  git 'Default'
  terraform 'terraform-latest'
}
 
 stages {
    stage("Git checkout Module1")
     {
        steps  {
                git branch: 'main', url: 'https://github.com/parthac1/Terraform-DNS-to-DB-Multi-Module/tree/main/Module1'

        }
      }
     stage ("Terraform init Module1") 
     {
        steps {
            sh 'terraform init'
        }
     }
       stage ("Terraform Plan Module1") 
     {
        steps {
            sh 'terraform plan'
        }
     }
       
         stage ("Terraform Apply Module1") 
     {
        steps {
            sh 'terraform apply -auto-approve'
        }
     }
  
  
    }


}