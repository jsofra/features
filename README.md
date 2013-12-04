# Merdian Features

Meridian Features is a geospatial feature library for Clojure.

Geospatial features are a standard convention for representing spatial entities on the earth. Features represent these entities by annotating geometries with addition properties that add semantic information, e.g. this line-string represents a road.

The Meridian Features library is intended to be used with the Meridian [Shapes] (http://github.com/jsofra/shapes) and Meridian [Georeference] (http://github.com/jsofra/georeference) libraries.

There is a base representation for features (as there is for their embedded geometry). The features are represented by standard Clojure data structures (maps or records). These feature structures map directly to the structures used in the [GeoJSON] (http://www.geojson.org/) specification. This conformance to the GeoJSON specification means that Shapes gets standardisation for free.

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
