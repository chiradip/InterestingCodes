;; The above recipe will remove duplicates from any collection that is linearly walkable 
;; note  the use of (some xxx) instead of (contains? xxx xxx). `contains?` is a very misleading name in many ways. It checks 
;; the presence of indices or keys and not the value 

(reduce (fn [a e] (if (some #(= e %) a) a (conj a e))) [] coll)

;; Examples 
<SHELL>  (reduce (fn [a e] (if (some #(= e %) a) a (conj a e))) [] '(1 2 3 4 5 6 4 2))
<RESULT> [1 2 3 4 5 6]
<SHELL>  (reduce (fn [a e] (if (some #(= e %) a) a (conj a e))) [] "abracadabra")
<RESULT> [\a \b \r \c \d]

