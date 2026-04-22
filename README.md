#  LAB 8 - Threads, AsyncTask et Handler

##  Objectif
Ce projet a pour objectif de comprendre :

- UI Thread vs Worker Thread  
- Utilisation de Thread pour exécuter des tâches en arrière-plan  
- Utilisation de AsyncTask avec progression  
- Maintenir une interface fluide sans blocage  

---

## Fonctionnalités

### 1. Charger image (Thread)
- Simule un chargement avec un Thread  
- L’image apparaît après quelques secondes  

### 2. Afficher Toast
- Vérifie que l’UI reste fluide pendant le chargement  

### 3. Calcul lourd (AsyncTask)
- Exécute un calcul en arrière-plan  
- Met à jour une ProgressBar de 0 à 100  

---

##  Démonstration

![Demo](demo.gif)

---

##  Explication

- Le **Thread** permet d'exécuter une tâche sans bloquer l’interface utilisateur  
- Le **Handler** permet de revenir au thread principal pour mettre à jour l’UI  
- Le **AsyncTask** exécute une tâche en arrière-plan avec une progression visible  

