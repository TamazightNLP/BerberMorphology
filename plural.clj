(defn plural [s]
        (if (= (first s) \a);; characters: \c
          (str \i (subs s 1) "en")))
;; to concatenate to a string:
;;(str string char/or sequence)
;; how to turn tamghart into timgharin
(str "ti"(subs s 2 (-(.length s) 1))"in")
;;USER> "timgharin"


;; lemmatization
;; how to turn the plural form into a singular form
;; special cases:
;; ulawen= ul
;; ifasen = afus
;; udmawen = udem

(defn en-plural [s]
        (if (= "en" (subs s(-(.length s)2)))
          (str \a (subs s 1 (-(.length s)2)))))


(defn awen-plural [s]
  (if (and
       (=(first s)\i)
       (= "awen" (subs s (-(.length s)4))))
    (str \i (subs s 1 2)\e (subs s 2 (-(.length s)4)))))


;; note: if we start with the en-plural function
;; the lemma function won't work correctly
;; because the awen ending has an 'en' in it too.
(defn lemma [s]
        (cond
            
            (and (=(first s) \i)
                  (= "awen" (subs s (-(.length s)4))))
            (awen-plural s)
            (and (=(first s )\i)
                 (= "en" (subs s(-(.length s)2))))
            (en-plural s)
            :else  s))
