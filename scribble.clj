
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

(defproject my-app "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot my-app.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
                             
(defn my-reverse
  "reverses a string"
  [string]
  (clojure.string/reverse string))                             
