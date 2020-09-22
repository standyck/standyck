### Welcome to Stan's Github

You won't see much here. That's because I have my own
[playground](https://gitlab.standyck.com) where I store my personal projects. I have found
that I prefer having my own gitlab server because:

1. I control everything
2. I learn more about lots of different things (server administration/configuration,
   docker, network administration, etc.)
3. It supports a distributive model. Many services everywhere rather than one service in
   one place.

My favorite language is [clojure](https://clojure.org/). Here's a freebee for your [next
job interview](https://wiki.c2.com/?FizzBuzzTest).

``` clojure
(defn fizzbuzz
  "Returns a lazy sequence of FizzBuzz values."
  []
  (let [fizz (cycle [nil nil "Fizz"])
        buzz (cycle [nil nil nil nil "Buzz"])
        nums (map inc (range))]
    (map (fn [f b n] (if (or f b)
                       (str f b)
                       (str n)))
         fizz buzz nums)))
```

[I tried to make one without any conditionals but couldn't quite do it.]
