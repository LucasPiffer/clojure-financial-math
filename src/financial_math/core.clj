(ns financial-math.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn power
  [base exponent]
  (let [steps exponent]
    (if (= steps 0)
      1
      (if (= steps 1)
        base
        (* base (power base (dec steps)))))))

(defn multiplication-table
  ([number] (multiplication-table number 1))
  ([number exp] (let [exponent exp]
                       (cons (power number exponent)
                             (lazy-seq (multiplication-table number (inc exponent)))))))

(take 3 (multiplication-table 2))

(power 2 2)

(defn future-value
  "returns the future value given interest and the period"
  [present-value i n]
  (* present-value (power (+ 1 i) n)))
