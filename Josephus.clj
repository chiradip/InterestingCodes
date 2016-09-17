;; lets build the deathrow list
(defn isolation [deathrow survivors skip]
    (if (= 1 (count survivors)) [deathrow survivors]
    (do
      (def new-skip (if (> skip (count survivors)) (- skip (count survivors)) skip))
      (isolation
        (concat deathrow (take 1 (drop (dec new-skip) survivors)))
        (concat (drop new-skip survivors)  (take (dec new-skip) survivors)) new-skip))))

(defn find-survivor [num skip]
  (def lop (range 0 num))
  (isolation (list) lop skip))

;; The below method is most elegant - 
(defn find-last-survivor [num skip]
  (loop [x (range 0 num)]
    (if (= (count x) 1) x
     (recur (take (- (count x) 1) (drop skip (cycle x)))))))
