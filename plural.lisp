;; general plural function:
(defun lastchar (x)
  (subseq (reverse x) 0 1))
(defun removet (word)
  (string-trim "t" word))
(defun plural (word)
  (cond ((equal 4 (length word))
	 (concatenate 'string (subseq word 0 2)
		      (lastchar word) "awen"))
	((and (equal "t" (subseq word 0 1))
	      (equal "t" (lastchar word)))
	 (concatenate 'string  "ti" (subseq (removet word) 1) "in"))
	(t (concatenate 'string "i" (subseq word 1) "en"))))
 
;;(write-line (plural "tamghart"))
;(write-line (string-trim "t" "tamghart"))
 
 
 
 
;;(write-line (string-right-trim "t" "tamghart"))