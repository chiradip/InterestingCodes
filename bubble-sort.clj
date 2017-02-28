(defn- bubble [acc stack]
		(if (= (count stack) 1) (concat stack acc)
			(let [remains (pop stack) top (peek stack) sectop (peek remains) remains2 (pop remains)]
				(if (< top sectop) 
					(concat (conj  remains2 top sectop) acc)
					(recur (cons top acc) (pop stack)))))) 

(defn sort-bubble [stack]
	(let [newstack (into [] (bubble [] stack))]
			(if (= newstack stack) stack
				(recur newstack))))
