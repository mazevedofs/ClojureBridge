(ns cipher.core-test
  (:require [cipher.core :as core]
            [midje.sweet :refer :all]))

(facts "recebe um caractere minúsculo e retorna sua posição no alfabeto: a = 0, b = 1, etc"
       (fact "o caractere a é a primeira letra, na posição 0"
             (core/to-int \a) => 0)
       (fact "o caractere b é a segunda letra, na posição 1"
             (core/to-int \b) => 1))

(facts "recebe um caractere minúsculo e retorna sua posição no alfabeto: a = 0, b = 1, etc"
       (tabular
         (core/to-int ?char) => ?result
         ?char ?result
         \a    0
         \b    1
         \c    2
         \d    3))


(facts "recebe um número e retorna um caractere minúsculo: 0 = a, 1 = b"
       (fact "o numero 0 é o caractere a"
             (core/to-char 0) => \a)
       (fact "o numero 0 é o caractere a"
             (core/to-char 1) => \b))


(facts "recebe um número e retorna um caractere minúsculo: 0 = a, 1 = b"
       (tabular
         (core/to-char ?int) => ?result
         ?int ?result
         0    \a
         1    \b
         2    \c))


(facts "move uma letra em um dado número de posições"
       (tabular
         (core/shift ?char 3 ) => ?result
         ?char ?result
         \a    \d
         \b    \e
         \z    \c
         )
       )


(facts "encripta usando a cifra de ceasar"
       (tabular (core/caesar-encrypt ?word 1) => ?result
                ?word     ?result
                "banana"  "cbobob"
                "bola"    "cpmb"))


(facts "encripta usando a cifra de ceasar"
       (tabular (core/caesar-decrypt ?word 1) => ?result
                ?word     ?result
                "cbobob"   "banana"
                "cpmb"    "bola"))


