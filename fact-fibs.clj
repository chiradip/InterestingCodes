(defn fact[x]
  (loop [current x next (dec x) total 1]
    (if (> next 0)
      (recur next (dec next) (* total current)) total)))

(defn fib-recur
([num]
  (loop [x num p-fib 0 curr-fib 1]
    (if (> x 0)
      (recur (dec x) curr-fib (+ p-fib curr-fib)) p-fib))))

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

