def call(Map args = [:]) {
    def lib = library(identifier: "jenkins@20211123", retriever: legacySCM(scm))

    sh "wget ${args.url} -O ${args.path}"
    def buildManifestObj = lib.jenkins.BuildManifest.new(readYaml(file: buildManifestPath))
    return buildManifestObj
}