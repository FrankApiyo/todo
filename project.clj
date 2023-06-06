(defproject todo "0.1.0-SNAPSHOT"
  :description "Code from the duct guide"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [duct/core "0.8.0"]
                 [duct/module.ataraxy "0.3.0"]
                 [duct/module.logging "0.5.0"]
                 [duct/module.sql "0.6.1"]
                 [duct/module.web "0.7.3"]
                 [duct/handler.sql "0.4.0"]
                 [duct/migrator.ragtime "0.3.2"]
                 [org.xerial/sqlite-jdbc "3.42.0.0"]]
  :plugins [[duct/lein-duct "0.12.3"]
            [lein-ancient "1.0.0-RC3"]]
  :main ^:skip-aot todo.main
  :resource-paths ["resources" "target/resources"]
  :prep-tasks     ["javac" "compile" ["run" ":duct/compiler"]]
  :middleware     [lein-duct.plugin/middleware]
  :profiles
  {:dev  [:project/dev :profiles/dev]
   :repl {:prep-tasks   ^:replace ["javac" "compile"]
          :repl-options {:init-ns user}}
   :uberjar {:aot :all}
   :profiles/dev {}
   :project/dev  {:source-paths   ["dev/src"]
                  :resource-paths ["dev/resources"]
                  :dependencies   [[integrant/repl "0.3.2"]
                                   [hawk "0.2.11"]
                                   [eftest "0.6.0"]
                                   [kerodon "0.9.1"]]}})
