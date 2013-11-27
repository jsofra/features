(ns meridian.features.protocols)

(defprotocol GeodeticOperations
  (orthodromic-dist [from-point to-point]))

#_(defn orthodromic-dist [p1 p2]
  (let [gc (GeodeticCalculator. (ref/decode-crs (ref/get-crs p1)))]
    (.setStartingGeographicPoint gc p1 (:lat (:coords p1)))
    (.setDestinationGeographicPoint gc (:lon (:coords p2)) (:lat (:coords p2)))
    (.getOrthodromicDistance gc)))

#_(defn lat-dists [crs]
  (let [points (map #(point crs [% 144]) (range -90 90 10))]
    (map (fn [[lat1 lon1] [lat2 lon2]]
           {:lat1 lat1 :lat2 lat2 :dist (/ (orthodromic-dist p1 p2) 1000)})
         points (rest points))))
