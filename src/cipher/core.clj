(ns cipher.core)

(def ascii-a (int \a))

(defn to-int
  "recebe uma letra minúscola e retorna sua posição no alfabeto: a = 0, b = 1, etc."
  [letter-char]
    (- (int letter-char) ascii-a))


(defn to-char
  "recebe um numero e retorna uma letra minuscula: 0 = a, 1 = c, etc."
  [int-char]
  (char (+ int-char ascii-a)))


(defn shift
  [letter key]
  (to-char (mod (+ (to-int letter) key) 26)))


(defn caesar-encrypt
  "encriptando uma palavra w com uma chave k utilizanado a cifra de César"
  [w k]
  (apply str (mapv #(shift % k) w)))


(defn caesar-decrypt
  "encriptando uma palavra w com uma chave k utilizanado a cifra de César"
  [w k]
  (apply str (mapv #(shift % (* k -1)) w)))
;str é uma operacao nativa para transformar uma sequencia em string, apply é funcao tbm