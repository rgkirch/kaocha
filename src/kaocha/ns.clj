(ns kaocha.ns
  (:refer-clojure :exclude [symbol])
  (:require [clojure.spec.alpha :as spec]
            [clojure.string :as str]
            [clojure.test :as t]
            [kaocha.core-ext :refer :all]
            [kaocha.result :as result]
            [kaocha.testable :as testable]
            [kaocha.type :as type]))

(defn required-ns [ns-name]
  (when-not (and (find-ns ns-name)
                 (contains? (loaded-libs) (symbol ns-name)))
    (require ns-name))
  (try
    (the-ns ns-name)
    (catch Exception _)))

(spec/def ::name simple-symbol?)
(spec/def ::ns   ns?)
