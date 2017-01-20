#lang racket
;#1a
(display "#1a")(newline)
(define (mi-to-km x)
  (* x 1.609))
(display "mi-to-km 1: ")
(mi-to-km 1)
(newline)

;#1b
(display "#1b")(newline)
(define (km-to-mi x)
  (* x .6215))
(display "km-to-mi 1: ")
(km-to-mi 1)
(newline)

;#2
(display "#2a returns 4")(newline)
(display "#2b returns 28")(newline)
(display "#2c returns 9")(newline)
(newline)

;#3
(display "#3")(newline)
(define (baz n)
  (define (bar a b)
    (define (foo a)
   (* a (+ a 2)))
   (if (= a 14)
       b
       (bar (+ a 1) (+ (foo a) b))))
   (bar 3 n))
(baz 10)
(newline)

;#4
(display "#4")(newline)
(define (sum-range from to [sum 0])
  (cond
    [(= from (+ to 1)) sum]
    [(> from to) (sum-range to from sum)]
    [(sum-range (+ from 1) to (+ sum from))]))
(display "sum-range 4 18: ")
(sum-range 4 18)
(display "sum-range 18 4: ")
(sum-range 18 4)
(display "sum-range 7 7: ")
(sum-range 7 7)
