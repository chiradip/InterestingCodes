
(clojure.string/split "I love my pizaa"  #" ") 
 
(slurp “myfile.txt”) 

(def my-file-content (slurp "myfile.txt"))

(print my-file-content)

(count (clojure.string/split my-file-content #"\n"))
