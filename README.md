# Merdian Features

Meridian Features

## Usage

```clojure
user> (require '[meridian.features :as f])
nil
user> (require '[meridian.shapes :as s])
nil
user> (f/feature (s/point [2 4]))
#meridian.features.Feature{:type :Feature,
                           :geometry #meridian.shapes.Point{:type :Point, :coordinates [2 4]}, :properties nil}
user> (f/feature-collection [(s/point [2 3]) (s/point [6 0])])
#meridian.features.FeatureCollection{:type :FeatureCollection,
                                     :features [#meridian.shapes.Point{:type :Point, :coordinates [2 3]}
                                                #meridian.shapes.Point{:type :Point, :coordinates [6 0]}]}
```

## License

Copyright © James Sofra, 2013

Distributed under the Eclipse Public License, the same as Clojure.
