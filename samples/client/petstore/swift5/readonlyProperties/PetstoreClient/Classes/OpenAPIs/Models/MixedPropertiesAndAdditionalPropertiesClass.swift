//
// MixedPropertiesAndAdditionalPropertiesClass.swift
//
// Generated by openapi-generator
// https://openapi-generator.tech
//

import Foundation


public struct MixedPropertiesAndAdditionalPropertiesClass: Codable { 


    public private(set) var uuid: UUID?
    public private(set) var dateTime: Date?
    public private(set) var map: [String:Animal]?

    public init(uuid: UUID?, dateTime: Date?, map: [String:Animal]?) {
        self.uuid = uuid
        self.dateTime = dateTime
        self.map = map
    }

}
