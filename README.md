# Évaluation Architectures Micro-services
## Problème :

On souhaite développer un POC (Proof Of Concept)sous forme d’une application web basée sur une architecture
micro-service an utilisant l’écosystème Spring Boot et Spring Cloud coté backend et un Framework comme
Angular ou React coté Frontend.

L’application doit permettre de gérer des porte feuilles (Wallets) de devises ainsi que les transferts entre les
portes feuilles. Pour faire plus simple, cette application se composera de deux micro-services fonctionnels :

• Un Micro-service qui permet de gérer des « Wallet ». Chaque Wallet appartient à un client. Un client est
défini par son id (numérique auto incrémenté), son nom et son email. Une Wallet est définie par son id
(String de type UUID), son solde, sa date de création, sa devise.

• Un Micro-service qui permet de gérer des transferts entre les Wallets. Chaque transfert est défini par
son id, sa date, Wallet source, Wallet destination, son montant, son état (PENDIND, VALIDATED,
REJECTED)

Les micro-services technique à mettre en place sont :

• Le service Gateway basé sur Spring cloud Gateway

• Le service Discovery base sur Eureka Server ou Consul Discovery (au choix)

• Le service de configuration basé sur Spring cloud config ou Consul Config (au choix)

Pour les micro-services, il faut générer la documentation des web services Restfull en utilisant la spécification
OpenAPIDoc (Swagger)

## Implementation:


### Creation des services : 
![img.png](images/img.png)

## Gateway:

![img_12.png](images/img_12.png)



### Discovery:
![img_4.png](images/img_4.png)
![img_5.png](images/img_5.png)
![img_6.png](images/img_6.png)

![img_7.png](images/img_7.png)


### client :
![img_2.png](images/img_2.png)

### wallet :
![img_3.png](images/img_3.png)

![img_13.png](images/img_13.png)



### test : 

![img_8.png](images/img_8.png)

Check H2 databases
![img_9.png](images/img_9.png)
![img_10.png](images/img_10.png)

Get wallets from discovery
![img_11.png](images/img_11.png)


### Transfer Service

![img_14.png](images/img_14.png)

![img_15.png](images/img_15.png)



