(ns standyck.core)

(comment
  "Having some fun with something I read about called Kaprekar's Routine."
  "Kaprekar's routine" "Will usually reach its fixed point, 6174 in at most 8 iterations."
  "1. Take any four-digit number, using at least two different digits (Leading zeros are allowed.)"
  "2. Arrange the digits in descending and then in ascending order to get two four-digit numbers, adding leading zeros if necessary"
  "3. Subtract the smaller number from the bigger number."
  "4. Go back to step 2 and repeat")

(defn more-than-2-digits?
  [n]
  {:pre [(int? n)]}
  (>= (count (apply hash-set (format "%04d" n)))
      2))

;; Here's the list of all the possible values.
(def valid-n-values (filter more-than-2-digits? (range 1 10000)))

(defn kaprekars-routine
  "A single iteration of the Kaprekar's routine."
  [n]
  {:pre [(int? n)
         (<= n 9999)
         (more-than-2-digits? n)]}
  (let [sorted-chars (sort (format "%04d" n))
        ascending    (apply str sorted-chars)
        descending   (apply str (reverse sorted-chars))]
    (Math/abs (- (Integer/parseInt ascending)
                 (Integer/parseInt descending)))))

(defn iterate-out-to
  "A function that returns the first take-value iterations of kaprekar's routine."
  ([take-value]
   (fn [n]
     (take take-value (iterate kaprekars-routine n))))
  ([] (iterate-out-to 8)))

(defn count-iterations
  "Counts how many iterations it takes to get to 6174."
  [n]
  (if (= 6174 n)
    0
    (loop [cnt 1 kval (kaprekars-routine n)]
      (if (= 6174 kval)
        cnt
        (recur (inc cnt) (kaprekars-routine kval))))))

(comment
  "Here is one iteration"
  (kaprekars-routine 3821)

  "Let's iterate out 8 times and watch it go to 6174."
  ((iterate-out-to) 3821)

  "How many iterations?"
  (count-iterations 3821)

  "Let's make a histogram"
  (sort (frequencies (map count-iterations valid-n-values)))

  )
