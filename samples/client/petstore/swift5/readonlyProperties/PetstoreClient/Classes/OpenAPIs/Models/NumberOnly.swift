//
// NumberOnly.swift
//
// Generated by openapi-generator
// https://openapi-generator.tech
//

import Foundation


public struct NumberOnly: Codable { 


    public private(set) var justNumber: Double?

    public init(justNumber: Double?) {
        self.justNumber = justNumber
    }

    public enum CodingKeys: String, CodingKey, CaseIterable { 
        case justNumber = "JustNumber"
    }

}
