# Fonctionnalités Principales
## 1. Gestion des Conférences:
o Création de conférences par un éditeur.
o Gestion des informations des conférences : titre, thématique, dates de 
début et fin, et état (ouverte, fermée, en évaluation).
o Association de soumissions à une conférence.
## 2. Gestion des Utilisateurs et Rôles :
o Les utilisateurs peuvent avoir plusieurs rôles : éditeur, auteur, évaluateur.
o Répartition des tâches : éditeur crée des conférences et attribue des 
soumissions, auteurs soumettent des articles, évaluateurs donnent des 
évaluations.
## 3. Gestion des Soumissions :
o Soumission d'articles par les auteurs avec un titre, un résumé, un PDF et 
une liste d'auteurs.
o Attribution des soumissions à des évaluateurs par un éditeur.
## 4. Gestion des Évaluations :
o Évaluation des soumissions assignées avec une note, des 
commentaires, et un état (accepté, rejeté, en révision).
o Accès aux évaluations par l'éditeur.

# Outils Utilisés
• # Spring Boot : Développement de l'API backend. 
• # Spring Data JPA : Gestion des entités et accès aux données. 
• # H2 : Base de données relationnelle pour stocker les informations. 
• # Postman : Tests des endpoints de l'API


# Structure de Projet 

```com.example.demo/
├── config/
│ └── SecurityConfig.java
├── controllers/
│ ├── ConferenceController.java
│ ├── EvaluationController.java
│ ├── SoumissionController.java
│ ├── UserAppController.java
│ └── RoleController.java
├── entities/
│ ├── AffecterRole.java
│ ├── Conference.java
│ ├── Soumission.java
│ ├── UserApp.java
│ ├── Evaluation.java
│ └── DetailsSoumission.java
├── enumerations/
│ ├── EvaluationStatus.java
│ ├── ConferenceStatus.java
│ └── UserRole.java
├── repositories/
│ ├── AffecterRoleRepository.java
Page 3
│ ├── ConferenceRepository.java
│ ├── EvaluationRepository.java
│ ├── SoumissionRepository.java
│ ├── UserAppRepository.java
│ └── DetailsSoumissionRepository.java
├── services/
│ ├── implementation/
│ │ ├── AffecterRoleServiceImpl.java
│ │ ├── ConferenceServiceImpl.java
│ │ ├── EvaluationServiceImpl.java
│ │ ├── SoumissionServiceImpl.java
│ │ └── UserAppServiceImpl.java
│ └── interfaces/
│ ├── AffecterRoleService.java
│ ├── ConferenceService.java
│ ├── EvaluationService.java
│ ├── SoumissionService.java
│ └── UserAppService.java
└── DemoApplication.java
