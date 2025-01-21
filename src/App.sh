#!/bin/bash
#Les tests ne sont pas complilé attention
javac -d ../build/ -cp .:../lib/jogamp-fat.jar utils/*.java controler/*.java model/*.java view/*.java view/dialogue/*.java view/rendu/*.java && java -cp ../build:../lib/jogamp-fat.jar view.Main
