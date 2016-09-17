(defn fact[x]
  (loop [current x next (dec x) total 1]
    (if (> next 0)
      (recur next (dec next) (* total current)) total)))

(defn fib-recur
([num]
  (loop [x num p-fib 0 curr-fib 1]
    (if (> x 0)
      (recur (dec x) curr-fib (+ p-fib curr-fib)) p-fib))))


(defn fib-recur
[num & store]
  (loop [x num p-fib 0 curr-fib 1 l '()]
    (if (> x 0)
      (recur (dec x) curr-fib (+ p-fib curr-fib)
            (if (not (nil? store)) (cons p-fib l) nil)) (if (not (nil? store))
                  (cons p-fib l) p-fib))))
