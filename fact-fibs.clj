(defn fact[x] 
  (if (<= x 2) x 
    (* x (fact (dec x)))))

(defn fact[x] 
  (cond 
    (< x 0) (throw (Exception. "factorial computation is limited for non-negative numbers only"))
    (<= x 2) x 
    :else (* x (fact (dec x)))))

(defn fact-recur[n]
  (loop [x n fact 1]
    (cond 
      (< x 0) (throw (Exception. "factorial computation is limited for non-negative numbers only"))
      (= x 0) 0
      (= x 1) fact
      :else (recur (dec x) (* fact x)))))

(defn fact[x]
  (loop [current x next (dec x) total 1]
    (if (> next 0)
      (recur next (dec next) (* total current)) total)))

(defn fib-recur
([num]
  (loop [x num p-fib 0 curr-fib 1]
    (if (> x 0)
      (recur (dec x) curr-fib (+ p-fib curr-fib)) p-fib))))

;; fibonacci with memoization 
(def fib-mem
  (memoize 
    (fn [n] 
      (cond 
        (< n 0) (throw (Exception. "Fibonacci is applicable for non-negative numbers only"))
        (<= n 1) n
        :else (+ (fib (- n 1)) (fib (- n 2)))))))

;; This one will produce a collection of fibonacci series which can be used to do other opertions on the series 
;; without computing them individually all over again just provide anything as the second argument and it will produce
;; the fibonacci series in list form in reverse order - use vector as the storing mechsnism to get the series in regular 
;; order
(defn fib-recur
[num & store]
  (loop [x num p-fib 0 curr-fib 1 l '()]
    (if (> x 0)
      (recur (dec x) curr-fib (+ p-fib curr-fib)
            (if (not (nil? store)) (cons p-fib l) nil)) (if (not (nil? store))
                  (cons p-fib l) p-fib))))

;; Using clojure reduce function
(reduce (fn [[a b] _] [b (+ a b)]) [0 1] (range 0 10))

(second (reduce (fn [[a b] _] [b (+ a b)]) [0 1] (range 0 10)))

(defn fib-reduce [num]
  (second (reduce (fn [[a b] _] [b (+ a b)]) [0 1] (range 0 num))))

(reduce (fn [acc el] (+ acc el)) [0 1 2 3 4 5  6])


(map (fn [element] (inc element)) [1 2 3])
(2 3 4)

(time (fib 50))
(time (fib-recur 50))
(time (fin-reduce 50))
