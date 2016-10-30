(def text-string "my very large text string")
(defn count-word [text] 
  (count (clojure.string/split text #" ")))
