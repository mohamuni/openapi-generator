//
// HasOnlyReadOnly.swift
//
// Generated by openapi-generator
// https://openapi-generator.tech
//

import Foundation
import AnyCodable

public final class HasOnlyReadOnly: Codable, Hashable {

    public var bar: String?
    public var foo: String?

    public init(bar: String? = nil, foo: String? = nil) {
        self.bar = bar
        self.foo = foo
    }
    public enum CodingKeys: String, CodingKey, CaseIterable {
        case bar
        case foo
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(bar, forKey: .bar)
        try container.encodeIfPresent(foo, forKey: .foo)
    }



    public static func == (lhs: HasOnlyReadOnly, rhs: HasOnlyReadOnly) -> Bool {
        lhs.bar == rhs.bar &&
        lhs.foo == rhs.foo
        
    }

    public func hash(into hasher: inout Hasher) {
        hasher.combine(bar?.hashValue)
        hasher.combine(foo?.hashValue)
        
    }

}
