# Thème : Interpreteur de Lsystem

## Description
Un L-System est un ensemble de règles et de symboles qui modélisent un processus de croissance d'êtres vivants comme des plantes ou des cellules. 
Le concept central des L-Systems est la notion de réécriture. La réécriture est une technique pour construire des objets complexes en remplaçant 
des parties d'un objet initial simple en utilisant des règles de réécriture.

Pour ce faire, les cellules sont modélisées à l'aide de symboles. À chaque génération, les cellules se divisent,
i.e. un symbole est remplacé par un ou plusieurs autres symboles formant un mot.

## Technologies Utilisées
- JAVA 
- SWING
- PATTERN OBSERVER
- PATTERN MVC

## Prérequis
- Installer Java(JDK) sur votre machine

## Utilisation

```bash
 cd src && chmod 711 App.sh
./App.sh
```
## Structure du code source

src
    ├── App.sh
    ├── controler
    │   └── AppController.java
    ├── Main.java
    ├── model
    │   ├── Generator.java
    │   └── Rule.java
    ├── test
    │   ├── TestGenerateur.java
    │   └── TestRegle.java
    ├── utils
    │   ├── Ecoutable.java
    │   ├── EcoutableModele.java
    │   ├── Ecouteur.java
    │   ├── Function.java
    │   ├── GeneratorException.java
    │   └── Position.java
    └── view
        ├── Configuration.java
        ├── dialogue
        │   ├── Dialog.java
        │   └── Help.java
        ├── Interface.java
        ├── Menu.java
        ├── RenderedZone.java
        ├── rendu
        │   ├── Rendu2D.java
        │   └── Rendu3D.java
        └── ToolBar.java

## Auteurs
    DIALLO Aissatou
    ADEKOYA Boluwatife
    COTCHO D. Z. Patrice
