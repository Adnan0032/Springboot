# Meteo application Spring Boot

Github link of the project :

https://github.com/Adnan0032/Springboot/tree/master

## Dépendances

1. **Spring Web**  
   Permet de créer des applications web (incluant REST) en simplifiant la configuration de Tomcat et des endpoints HTTP.

2. **Spring Data JPA**  
   Simplifie l’utilisation de JPA/Hibernate pour interagir avec la base de données.

3. **Hibernate**  
   Implémentation de JPA, permettant le mapping Objet/Relationnel (ORM) pour gérer la persistance des entités en base.

4. **H2**  
   Base de données embarquée, facile à configurer pour les développements ou tests.  
   Les données sont volatiles (en mémoire) et peuvent être persistées dans un fichier si on le souhaite.

5. **Thymeleaf**  
   Moteur de templates pour générer du HTML dynamique côté serveur.

6. **DevTools**  
   Aide au développement en redémarrant l’application automatiquement après chaque modification du code.

   
Q1 : Comment l'URL d'appel /greeting a-t-elle été configurée ?

L'annotation @GetMapping permet de définir l'URL accessible. En spécifiant /greeting dans cette annotation, nous indiquons que cette URL est liée à la méthode correspondante.

Q2 : Comment choisit-on le fichier HTML à afficher ?

Le nom du fichier HTML à afficher est déterminé par la valeur de retour de la méthode. Par exemple, en retournant "nomFichier", Spring cherche un fichier nomFichier.html dans les dossiers de templates configurés.

Q3 : Comment transmettons-nous le nom à qui nous disons bonjour dans le second lien ?

L'annotation @RequestParam permet de récupérer les paramètres transmis dans l'URL. Par exemple, avec @RequestParam(name="nameGET"), la variable nameGET contient la valeur passée dans l'URL en tant que paramètre nameGET.

Étape 17/18 : Pourquoi une table Address est-elle automatiquement créée dans la base de données ?

La table Address est générée automatiquement grâce aux annotations suivantes dans l'entité :

    @Entity : Signale à Spring qu'une classe représente une table dans la base de données.
    @Id : Identifie l'attribut qui sert de clé primaire.

Ces annotations permettent à Spring JPA d'établir une correspondance entre la classe Java et la structure de la base de données.

Étape 20 : Pourquoi le fichier data.sql est-il correctement inséré dans la base de données ?

Le fichier data.sql est exécuté correctement grâce à la ligne de configuration suivante, ajoutée avant l'exécution :

      spring.jpa.defer-datasource-initialization=true

Cela garantit que l'initialisation des données se fait après la configuration de la source de données.

Étape 23 : À quoi sert l'annotation @Autowired ?

@Autowired permet d'activer l'injection de dépendances. 

Elle permet à Spring d'instancier automatiquement les objets nécessaires à une classe, en évitant d'avoir à les créer manuellement. Ces objets sont pris en charge à partir du contexte d'application de Spring.

Étape 30 : Pourquoi avons-nous intégré Bootstrap via un CDN ?

L'intégration de Bootstrap via un CDN est une solution pratique et performante. Elle permet d'utiliser directement les fichiers CSS et JavaScript hébergés sur des serveurs optimisés, ce qui améliore la vitesse de chargement des pages. De plus, une mise à jour est simplifiée, car il suffit de modifier l'URL du CDN sans avoir à gérer des fichiers locaux.

Partie 2 : Appel de l'API MeteoConcept

Est-il nécessaire d'avoir un token pour appeler l'API MeteoConcept ?

Oui, un token est obligatoire pour accéder à l'API.

Quelle URL devons-nous appeler ?

L'URL de l'API est :

         https://api.meteo-concept.com/api/forecast/daily

Il faut y ajouter les paramètres nécessaires (token, latitude et longitude).

Quelle méthode HTTP est utilisée ?

La méthode utilisée est GET.

Comment les paramètres sont-ils transmis ?

Les paramètres sont inclus directement dans l'URL :

    https://api.meteo-concept.com/api/forecast/daily/0?token={API_KEY}&latlng={Lat},{Lon}

Où trouver les informations sur la température et la météo ?
Ces informations sont disponibles dans le corps de la réponse de l'API, sous l'objet forecast.

Les attributs tmin et tmax correspondent aux températures minimale et maximale.

Les autres informations météorologiques (probabilité de brouillard, vitesse du vent, etc.) se trouvent également dans l'objet forecast sous les attributs tels que probafog, wind10m, sun_hours, etc.

