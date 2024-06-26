(defproject bodminroadrunners "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "https://www.borminroadrunners.uk"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [stasis "2.3.0"]
                 [ring "1.2.1"]
                 [hiccup "1.0.5"]
                 [me.raynes/cegdown "0.1.1"]
                 [enlive "1.1.5"]
                 [clygments "0.1.1"]
                 [optimus "0.14.2"]]
  :ring {:handler bodminroadrunners.web/app}
  :aliases {"build-site" ["run" "-m" "bodminroadrunners.web/export"]}
  :profiles {:dev {:plugins [[lein-ring "0.8.10"]]}})
