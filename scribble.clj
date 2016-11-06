
(clojure.string/split "I love my pizaa"  #" ") 
 
(slurp “myfile.txt”) 

(def my-file-content (slurp "myfile.txt"))

(print my-file-content)

(count (clojure.string/split my-file-content #"\n"))

(count (clojure.string/split my-file-content #”\n+"))

(ns my-app.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
