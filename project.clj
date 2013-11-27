(defproject meridian/features "0.0.2-SNAPSHOT"
  :description "Meridian Features is a library for specifying and peforming operations on geospatially referenced features and geometries in Clojure."
  :url "http://github.com/jsofra/features"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [meridian/shapes "0.0.2-SNAPSHOT"]
                 [meridian/clj-jts "0.0.2-SNAPSHOT"]
                 [meridian/shapes-impl "0.0.2-SNAPSHOT"]
                 [meridian/georeference "0.0.2-SNAPSHOT"]
                 [org.geotools/gt-jts-wrapper "10.1"]
                 [org.geotools/gt-referencing "10.1"]]
  :repositories {"osgeo.org" "http://download.osgeo.org/webdav/geotools/"})
