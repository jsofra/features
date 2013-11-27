(ns meridian.features
  (:require [meridian.flatland :as fl]
            [meridian.flatland.protocols :as flp]
            [meridian.georeference :as r]
            [meridian.georeference.protocols :as rp]))

(defrecord Feature [type geometry properties])
(defrecord FeatureCollection [type features])

(defn feature [geometry & {:keys [id crs bbox properties] :as options}]
  (merge (->Feature :Feature geometry properties) options))

(defn feature-collection [features & {:keys [crs bbox] :as options}]
  (merge (->FeatureCollection :FeatureCollection features) options))

(doseq [t [Feature FeatureCollection clojure.lang.IPersistentMap]]
  (extend t rp/Referenced
          {:resolve-crs (fn [this crs-lookup] (crs-lookup (:crs this)))}))

(extend-protocol rp/Transformable
  Feature
  (transform [this from-crs to-crs mt-lookup]
    (let [geom (:geometry this)]
      (-> this
          (assoc :geometry (rp/transform geom from-crs to-crs mt-lookup))
          (assoc :crs (r/named-crs (rp/->SRS to-crs))))))
  FeatureCollection
  (transform [this from-crs to-crs mt-lookup]
    (let [feats (:features this)]
      (-> this
          (assoc :features (mapv #(rp/transform % from-crs to-crs mt-lookup) feats))
          (assoc :crs (r/named-crs (rp/->SRS to-crs)))))))
