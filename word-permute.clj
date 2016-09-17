(defn permute 
  ([s] (distinct (flatten (permute "" s))))
  ([pre s]
    (if (<= (count s) 1) (str pre s) 
      (for [i (range 0 (count s))]
        (permute 
          ;; modify the pre
          (str pre (.substring s i (inc i)))
          ;; modify the string 
          (str (.substring s 0 i) (.substring s (inc i))))))))
